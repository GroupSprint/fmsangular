import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { Flight } from '../Flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-createflight',
  templateUrl: './createflight.component.html',
  styleUrls: ['./createflight.component.css']
})
export class CreateflightComponent implements OnInit {
  addForm!: FormGroup;
  Submitted = false;
  flight: Flight = new Flight();
  constructor(private service: FlightService, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      carrierName: ['', Validators.required],
      flightModel: ['', Validators.required],
      seatCapacity: ['', Validators.required],
    });
  }
  createflight() {
    {
      this.Submitted = true;
      if (this.addForm.invalid) {
        return;
      }

      else {
        this.service.createflight(this.flight)
          .subscribe(
            data => {
              console.log(data); this.flight.carrierName = this.addForm.value.carrierName;
              this.flight.flightModel = this.addForm.value.flightModel;
              this.flight.seatCapacity = this.addForm.value.seatCapacity;
              alert('Flight is added');
              this.router.navigate(['/flightdetails'])
            },
            error => { console.log(error); alert(error); }
          );
      }

    }
  }
}