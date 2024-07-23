package com.site.pathfinder2024.service;

import com.site.pathfinder2024.data.RouteRepository;
import com.site.pathfinder2024.model.Picture;
import com.site.pathfinder2024.model.Route;
import com.site.pathfinder2024.service.dto.RouteShortInfoDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private RouteRepository routeRepository;
    private Random random;
    private ModelMapper modelMapper;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.modelMapper = new ModelMapper();
        this.random = new Random();
    }

    @Transactional
    public RouteShortInfoDTO getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount) + 1;

        Optional<Route> randomRoute = routeRepository.findById(randomId);

        if (randomRoute.isEmpty()) {
            throw new IllegalArgumentException("");
        }

      return mapToShortInfo(randomRoute.get());
    }

    @Transactional
    public List<RouteShortInfoDTO> getAllRoutes() {
        return routeRepository.findAll()
            .stream()
            .map(this::mapToShortInfo)
            .toList();

    }

    private RouteShortInfoDTO mapToShortInfo(Route route) {
        RouteShortInfoDTO dto = modelMapper.map(route, RouteShortInfoDTO.class);

        Optional<Picture> first =  route.getPictures().stream().findFirst();
        dto.setImageUrl(first.get().getUrl());

        return dto;

    }


//    private RouteShortInfoDTO mapRouteToRouteShortInfoDTO(Route route) {
//        RouteShortInfoDTO routeShortInfoDTO = new RouteShortInfoDTO();
//        routeShortInfoDTO.setId(route.get);
//    }

}
