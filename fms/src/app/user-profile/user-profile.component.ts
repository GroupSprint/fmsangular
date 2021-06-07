import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  users!: User[];
  user: User= new User();
  Edit:boolean= false;;
  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.reloadData();
  }
 
  reloadData() {
    var uid:string =sessionStorage.getItem('userId') as string;
    this.user.userId=+uid;
    this.service.getuserById(this.user.userId).subscribe(
      data => {
        console.log(data); this.user=data; },
      error => { console.log(error);  alert(error);}
    );
  }

  detail(Id:number):void{
    this.Edit=true;
    this.service.getuserById(Id)
      .subscribe(
        data => { console.log(data); this.user=data},
        error => { console.log(error);  alert(error);}
      ); 
  } 
 
  edituser():void{
    this.Edit= false;
   this.service.updateuser(this.user)
   .subscribe(
     data => { console.log(data);  this.user=data ; alert('Details updated')},
     error => { console.log(error);  alert(error);}
   )
}
}
