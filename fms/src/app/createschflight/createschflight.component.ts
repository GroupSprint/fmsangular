import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ScheduledFlight } from '../ScheduledFlight';
import { ScheduleflightService } from '../scheduleflight.service';

@Component({
  selector: 'app-createschflight',
  templateUrl: './createschflight.component.html',
  styleUrls: ['./createschflight.component.css']
})
export class CreateschflightComponent implements OnInit {

  schflight:ScheduledFlight = new ScheduledFlight(); 
  addForm!: FormGroup;
  constructor(private service: ScheduleflightService,private formBuilder: FormBuilder,private router: Router) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      schdate: [''],
      flightId: [''],
      scheduleId:[''],
      fares:[''],
      availableSeats:['']
    });
  }
  createscheduleflight(){
    this.schflight.schdate = this.addForm.value.schdate;
    this.schflight.flight.flightId = this.addForm.value.flightId;
     this.schflight.fares = this.addForm.value.fares;
     this.schflight.schedule.scheduleId = this.addForm.value.scheduleId;
     this.schflight.availableSeats = this.addForm.value.availableSeats;
     this.service.addscheduleflight(this.schflight).subscribe(
       data => { console.log(data); alert('Scheduled For Flight Created'); this.router.navigate(['/Scheduleflightdetails'])},
       error => { console.log(error);  alert(error);}
     );
  }
}
