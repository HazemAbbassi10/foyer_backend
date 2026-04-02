package tn.esprit.spring.test.services;

import tn.esprit.spring.test.entities.Bloc;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();

    public Bloc retrieveBloc(Long blocId);

    public Bloc addBloc(Bloc c);

    public void removeBloc(Long blocId);

    public Bloc modifyBloc(Bloc bloc);

    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);
}
