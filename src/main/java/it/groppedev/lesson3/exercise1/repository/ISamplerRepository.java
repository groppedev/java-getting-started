package it.groppedev.lesson3.exercise1.repository;

import it.groppedev.lesson3.exercise1.model.Sampler;

public interface ISamplerRepository
{
	Sampler load(String id);
	
	void save(Sampler sampler);
}
