package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.dtos.PeliculaDTO;
import com.movieFinder.movieFinderAPI.mappers.PeliculaMapper;
import com.movieFinder.movieFinderAPI.repositories.PeliculaRepository;
import com.movieFinder.movieFinderAPI.services.PeliculaService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Lazy
@Component
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Value("${app.api.key}")
    private String apiKey;
    /**
     * Este método llama a otro método el cual obtiene las 20 películas de la base de datos y las almacena en la base de datos
     */
    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void almacenarPeliculas() {
        List<PeliculaDTO> peliculas = insertarPeliculas();
        for (PeliculaDTO peliculaDTO: peliculas) {
            peliculaRepository.save(PeliculaMapper.convertirAModelo(peliculaDTO));
        }
    }

    private List<PeliculaDTO> insertarPeliculas(){
        List<PeliculaDTO> peliculas = new ArrayList<>();
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

        return peliculas;
    }
}
