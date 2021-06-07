import { Component, OnInit } from '@angular/core';
import { ScheduledFlight } from '../ScheduledFlight';
import { ScheduleflightService } from '../scheduleflight.service';

@Component({
  selector: 'app-scheduleflight',
  templateUrl: './scheduleflight.component.html',
  styleUrls: ['./scheduleflight.component.css']
})
export class ScheduleflightComponent implements OnInit {

  scheduleflight!:ScheduledFlight[];
  schflight: ScheduledFlight = new ScheduledFlight();
  constructor(private service: ScheduleflightService) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
   this.service.getScheduleFlight().subscribe(
    data => { console.log(data); this.scheduleflight=data },
      error => { console.log(error);  alert(error);}
    ); 
  }
addschflights(){
  this.service.addscheduleflight(this.schflight).subscribe(
    data => {console.log(data); this.schflight=data}
  )
}
}
