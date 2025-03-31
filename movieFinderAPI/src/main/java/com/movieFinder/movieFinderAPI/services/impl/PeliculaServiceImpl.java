package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.dtos.PeliculaDTO;
import com.movieFinder.movieFinderAPI.dtos.PeliculaGeneroDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.mappers.PeliculaMapper;
import com.movieFinder.movieFinderAPI.repositories.PeliculaRepository;
import com.movieFinder.movieFinderAPI.services.PeliculaGeneroService;
import com.movieFinder.movieFinderAPI.services.PeliculaService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

@Service
@Lazy
@Component
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private PeliculaGeneroService peliculaGeneroService;
    @Value("${app.api.key}")
    private String apiKey;
    /**
     * Este método llama a otro método el cual obtiene las 20 películas de la base de datos y las almacena en la base de datos
     */
    //@EventListener(ApplicationReadyEvent.class)
    @Override
    public void almacenarPeliculas() {
        //Recuperamos ambas listas en un hashmap
        Map<String,Object> listas = insertarPeliculas();
        //Guardamos cada lista (la de las películas y los géneros)
        List<PeliculaDTO> peliculas = (List<PeliculaDTO>) listas.get("peliculas");
        Map<Integer, JSONArray> generos= (Map<Integer, JSONArray>) listas.get("generos");
        //Recorremos cada lista y la guardamos en base de datos
        for (PeliculaDTO peliculaDTO: peliculas) {
            peliculaRepository.save(PeliculaMapper.convertirAModelo(peliculaDTO));
        }

        for (int clave: generos.keySet()) {
            peliculaGeneroService.insertGenerosPeliculas(clave,convertirJsonArrayAIntArray(generos.get(clave)));
        }

    }

    private int[] convertirJsonArrayAIntArray(JSONArray jsonArray) {
        int[] resultado = new int[jsonArray.length()]; // Crear array del mismo tamaño
        for (int i = 0; i < jsonArray.length(); i++) {
            resultado[i] = jsonArray.getInt(i); // Extraer cada entero
        }
        return resultado;
    }

    private Map<String,Object> insertarPeliculas(){
        List<PeliculaDTO> peliculas = new ArrayList<>();
        //Aquí guardamos ambas listas para retornarlas
        Map<String,Object> listas = new HashMap<>();
        //En este HashMap guardamos como clave el identificador de la película y como valor un array de enteros
        //El array de enteros son los identificadores de los géneros a los que pertenece la película.
        Map<Integer, JSONArray> generos = new HashMap<>();
        int actualPage = 1;
        final int MAX_PAGES = 500;
        try {
            while (actualPage<=MAX_PAGES) {
                URL url = new URL("https://api.themoviedb.org/3/movie/top_rated?language=es-ES&page=" + actualPage);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("accept", "application/json");
                connection.setRequestProperty("Authorization", "Bearer " + apiKey);
                connection.setRequestMethod("GET");
                Thread.sleep(100);
                connection.connect();
                if (connection.getResponseCode() != 200) {
                    System.out.println("ERROR: " + connection.getResponseMessage());
                } else {
                    StringBuilder information = new StringBuilder();
                    Scanner sc = new Scanner(connection.getInputStream());

                    while (sc.hasNext()) {
                        information.append(sc.nextLine());
                    }

                    sc.close();

                    JSONArray jsonArray = new JSONObject(information.toString()).getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        PeliculaDTO pelicula = new PeliculaDTO();
                        pelicula.setIdPelicula(jsonObject.getInt("id"));
                        pelicula.setTituloOriginalPelicula(jsonObject.getString("original_title"));
                        pelicula.setSinopsisPelicula(jsonObject.getString("overview"));
                        pelicula.setUrlPosterPelicula(jsonObject.isNull("poster_path") ? "" : jsonObject.getString("poster_path"));
                        pelicula.setFechaSalidaPelicula(
                                jsonObject.isNull("release_date") || jsonObject.getString("release_date").isEmpty()
                                        ? null
                                        : LocalDate.parse(jsonObject.getString("release_date"))
                        );
                        pelicula.setTituloPelicula(jsonObject.getString("title"));
                        //Por cada película guardamos en un HashMap el identificador de la pelicula como clave y como valor un JSONArray de los identificadores de géneros
                        generos.put(pelicula.getIdPelicula(),jsonObject.getJSONArray("genre_ids"));
                        peliculas.add(pelicula);
                    }

                }
                System.out.println("PELÍCULAS DE LA PÁGINA " + actualPage + " GUARDADAS");
                actualPage++;
            }
            System.out.println("PELÍCULAS GUARDADAS");
        }catch (Exception e) {
            e.printStackTrace();
        }
        //Guardamos la lista de pelis y el hashmap de los géneros en un hashmap para poder retornar ambas listas
        listas.put("peliculas",peliculas);
        listas.put("generos",generos);
        return listas;
    }

    @Override
    public List<PeliculaDTO> obtenerPeliculas() {
        PageRequest pageable = PageRequest.of(0,100);
        return PeliculaMapper.convertirLista(peliculaRepository.findMoviesByDate(pageable));
    }

    @Override
    public PeliculaDTO obtenerPeliculaById(int idPelicula) throws IdNotFoundException {
        return PeliculaMapper.convertirADTO(peliculaRepository.findById(idPelicula).orElseThrow(()-> new IdNotFoundException("La película no existe")));
    }

    @Override
    public List<PeliculaDTO> findMoviesByGenreId(int idGenero) {
        return PeliculaMapper.convertirLista(peliculaRepository.findMoviesByGenreId(idGenero));
    }
}
