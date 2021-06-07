import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { Flight } from '../Flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {

  editform: string = 'none';
  flight : Flight = new Flight();
  flights!: Observable<Flight[]>;
  isDivVisible: boolean= false;
  constructor(private service: FlightService,private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }
 
  reloadData() {
    this.flights = this.service.getflights();
  }

  remove(flightId:number):void{
    this.flights = this.service.removeflightById(flightId);
    alert('Flight Information Deleted');
    this.reloadData()
  }

  detail(flightId:number):void{
    this.service.geflightById(flightId)
      .subscribe(
        data => { console.log(data); this.flight=data},
        error => { console.log(error);  alert(error);}
      );    
}
editnew(flightId:number):void{

  this.isDivVisible=true;
  this.service.geflightById(flightId)
    .subscribe(
      data => { console.log(data); this.flight=data},
      error => { console.log(error);  alert(error);}
    );    
}
 editflight():void{
   this.isDivVisible= false;
  this.service.editflight(this.flight)
  .subscribe(
    data => { console.log(data);  this.flight=data ; alert('Flight Information Updated');this.reloadData()},
    error => { console.log(error);  alert(error);}
  )
}

}