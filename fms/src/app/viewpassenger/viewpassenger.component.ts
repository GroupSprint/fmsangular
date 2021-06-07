import { Component, OnInit } from '@angular/core';
import { Passenger } from '../Passenger';
import { PassengerService } from '../passenger.service';

@Component({
  selector: 'app-viewpassenger',
  templateUrl: './viewpassenger.component.html',
  styleUrls: ['./viewpassenger.component.css']
})
export class ViewpassengerComponent implements OnInit {
  
  passengers!: Passenger[];
  passenger : Passenger = new Passenger();
  constructor(private service : PassengerService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.service.getPassengerList()
      .subscribe(
        data => { console.log(data); this.passengers=data },
        error => { console.log(error);  alert(error);}
      ); 
    }

    detail(pnrNumber:number):void{
      this.service.getPassenger(pnrNumber)
        .subscribe(
          data => { console.log(data); this.passenger=data },
          error => { console.log(error);  alert(error);}
        );    
  }

}