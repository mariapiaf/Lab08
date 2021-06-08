package it.polito.tdp.extflightdelays.model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private ExtFlightDelaysDAO dao;
	private Graph<Airport, DefaultWeightedEdge> grafo; 
	private Map<Integer, Airport> idMap;
	
	public Model() {
		dao = new ExtFlightDelaysDAO();
		idMap = new LinkedHashMap<Integer, Airport>();
		dao.loadAllAirports(idMap);
	}
	
	public void creaGrafo(int distMin) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		dao.loadAllAirports(idMap);
		Graphs.addAllVertices(grafo, idMap.values());
		
		for(Connessione c: dao.getConnessioni(distMin, idMap)) {
			Graphs.addEdge(grafo, idMap.get(c.getA1().getId()),idMap.get(c.getA2().getId()), c.getPeso());
		}
		
	}
	public List<Connessione> getArchi(int dist){
		List<Connessione> result = new LinkedList<Connessione>();
		for(Connessione c: dao.getConnessioni(dist, idMap)) {
			result.add(c);
		}
		return result;
	}
	public int getNumeroVertici() {
		return grafo.vertexSet().size();
	}
	
	public int getNumeroArchi(int dist) {
		return grafo.edgeSet().size();
	}
}
