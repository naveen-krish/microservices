package lab.spboot.hateoas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.json.JSONArray;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab.spboot.hateoas.model.Antricicclagio;
import lab.spboot.hateoas.model.ApiInput;

@RestController
@RequestMapping(value = "")

public class HateoasController {

	@PostMapping(value="/v1/antricicclagio")
	public HttpEntity<Antricicclagio> arPush(ApiInput input) {
		
		Antricicclagio acc = new Antricicclagio();
		acc.setInput1("idSogg");
		acc.setInput2("motivi");
		
	        Link api_document_link = new Link("http://api.developer.antricclagio.com/documentation#anagrafe-ricerca").withRel(" API Documentation ");
		acc.add(linkTo(methodOn(HateoasController.class).anagrafe(input)).withRel(" Transition : anagrafe-ricerca "),
				api_document_link);
		  
		  
		 return new ResponseEntity<>(acc,HttpStatus.OK);
	}
	
	@PostMapping("/v1/antricicclagio/anagrafe")
	public HttpEntity<Antricicclagio> anagrafe(ApiInput input) {
	 
		Antricicclagio acc = new Antricicclagio();
		acc.setInput1("numeroCont");
		acc.setInput2("motivi");
		acc.setInput3("idBolletino");
		Link api_document_link = new Link("http://api.developer.antricclagio.com/documentation#Sconfino").withRel(" API Documentation ");
		
		acc.add(linkTo(methodOn(HateoasController.class).sconfino(input)).withRel(" Transition : sconfino "),api_document_link);
		
		 return new ResponseEntity<>(acc,HttpStatus.OK);
	}
	
	@PostMapping("/v1/antricicclagio/sconfino")
	public HttpEntity<ApiInput> sconfino(ApiInput input) {
	 
		 return new ResponseEntity<>(input,HttpStatus.OK);
	}
}
