import { Component, OnInit } from '@angular/core';
import { Schedule } from '../Schedule';
import { ScheduleService } from '../schedule.service';
import {FormGroup,FormBuilder} from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  schedules!: Schedule[];
  schedule: Schedule= new Schedule();
  addForm!: FormGroup;
  constructor(private service: ScheduleService,private formBuilder: FormBuilder,private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
    this.addForm = this.formBuilder.group({
      arrivaltime: [''],
      departuretime: [''],
      sairportid:[''],
      dairportid:['']
    });
  }
 
  reloadData() {
  this.service.getAllSchedules().subscribe(
      data => { console.log(data); this.schedules=data },
      error => { console.log(error);  alert(error);}
    ); 
  }

  createschedule(){
    this.schedule.airrivalTime = this.addForm.value.arrivaltime;
    this.schedule.departureTime = this.addForm.value.departuretime;
    console.log(this.schedule.sourceAirport);
     this.schedule.sourceAirport.airportid = this.addForm.value.sairportid;
     this.schedule.destinationAirport.airportid = this.addForm.value.dairportid;
     this.service.addschedule(this.schedule).subscribe(
       data => { console.log(data); alert('Scheduled is added'); this.router.navigate(['/Scheduledetails'])},
       error => { console.log(error);  alert(error);}
     );
  }
}
