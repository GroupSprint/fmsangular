import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { Airport } from '../Airport';
import { AirportService } from '../airport.service';

@Component({
  selector: 'app-airport',
  templateUrl: './airport.component.html',
  styleUrls: ['./airport.component.css']
})
export class AirportComponent implements OnInit {
  errors!:string;
  airport : Airport = new Airport();
  airports!: Observable<Airport[]>;
  constructor(private service: AirportService,private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }
 
  reloadData() {
    this.airports = this.service.getAirports();
  }

    detail(airportid:number):void{
      this.service.geAirportById(airportid)
        .subscribe(
          data => { console.log(data); this.airport=data},
          error => { console.log(error);  
          
            this.errors=error.error.message;
           }
        );    
      
}
}
