import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { HomeService } from '../home.service';
import { ScheduledFlight } from '../ScheduledFlight';
import { ScheduleflightService } from '../scheduleflight.service';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {

  scheduledFlight:ScheduledFlight=new ScheduledFlight();
  addForm!:FormGroup;
  schFlights!:ScheduledFlight[];
  city=['Mumbai','Pune','Banglore','Delhi','Hyderabad','Kolkata','Ahmedabad','Chennai','Kochi','Jaipur','Thiruvananthapuram']
  
  constructor(private service:HomeService,private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit(): void {
    this.addForm=this.formBuilder.group({
      source:[''],destination:[''],schdate:[],
    });
  }

  getScheduledFlightByAirport() {
    this.scheduledFlight.source=this.addForm.value.source;
    this.scheduledFlight.destination=this.addForm.value.destination;
    this.scheduledFlight.schdate=this.addForm.value.schdate;

    if(this.scheduledFlight.source===this.scheduledFlight.destination)
    {
      alert("Source and Destination airport cannot be same.")
    }
    else{
      this.service.getScheduleFlightByAirort(this.scheduledFlight.source,this.scheduledFlight.destination,this.scheduledFlight.schdate)
     .subscribe(
      data => {
        if(data==''){
          alert("No flight available")
        }
         console.log(data); this.schFlights=data;
      },
        error => { console.log(error);alert("No flight available")}
      );

    }
  }

  jump(scheduleFlightId : number){

    this.service.getScheduleflightById(scheduleFlightId)
       .subscribe(
         data => { console.log(data);
          sessionStorage.key(scheduleFlightId);
          
          // this.scheduledFlight=data;
        // sessionStorage.setItem('scheduleFlightId',scheduleFlightId)
      },
         error => { console.log(error);  alert(error);}
       );
    this.router.navigate(['/createbooking']);
  }

  // detail(flightId:number):void{
  //   this.service.geflightById(flightId)
  //     .subscribe(
  //       data => { console.log(data); this.flight=data},
  //       error => { console.log(error);  alert(error);}
  //     ); 
}