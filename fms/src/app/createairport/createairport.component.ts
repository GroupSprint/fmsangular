import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Airport } from '../Airport';
import { AirportService } from '../airport.service';

@Component({
  selector: 'app-createairport',
  templateUrl: './createairport.component.html',
  styleUrls: ['./createairport.component.css']
})
export class CreateairportComponent implements OnInit {
  addForm!: FormGroup;
  Submitted = false;
  airport: Airport = new Airport();
  constructor(private service:AirportService,private router:Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      airportName: ['', Validators.required],
      airportLocation: ['', Validators.required],
    });
  }

  createAirport(){
    this.Submitted = true;
    if (this.addForm.invalid) {
      return;  }

      else
      {
    this.service.createairport(this.airport)
     .subscribe(
       data => { console.log(data);  this.airport.airportName=this.addForm.value.airportName;
       this.airport.airportLocation=this.addForm.value.airportLocation; alert('Airport is added');
     this.router.navigate(['/airportdetails'])},
       error => { console.log(error);  alert(error);}
     );}
 }
}
