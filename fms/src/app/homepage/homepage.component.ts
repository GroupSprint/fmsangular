import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { HomeService } from '../home.service';
import { ScheduledFlight } from '../ScheduledFlight';
import { ScheduleflightService } from '../scheduleflight.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  
  minDate: any = "";
  scheduledFlight:ScheduledFlight=new ScheduledFlight();
  addForm!:FormGroup;
  schFlights!:ScheduledFlight[];
  city=['Mumbai','Pune','Banglore','Delhi','Hyderabad','Kolkata','Ahmedabad','Chennai','Kochi','Jaipur','Thiruvananthapuram']
  
  constructor(private service:HomeService,private formBuilder:FormBuilder,private schService: ScheduleflightService,private router:Router) { }

  ngOnInit(): void {
    this.getDate();
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

  jumplogin(){
    this.router.navigate(['/Login']);
  }

  getDate(){
    var date:any = new Date();
    var toDate:any = date.getDate();
    if(toDate<10)
    {
      toDate = '0'+ toDate;
    }
    var month= date.getMonth() +1;
    if(month < 10){
      month ='0' +month;
    }
    var year = date.getFullYear();

    this.minDate = year + "-" + month + "-" + toDate;
    //  console.log(this.minDate);

  }
}
