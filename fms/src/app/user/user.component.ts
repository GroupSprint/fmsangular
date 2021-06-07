import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users!: User[];
  user: User= new User();
  isDivVisible: boolean= false;
  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.reloadData();
  }
 
  reloadData() {
    this.service.getUsers().subscribe(
      data => {
        console.log(data); this.users=data; },
      error => { console.log(error);  alert(error);}
    );
  }
  
  remove(userId:number):void{
    this.service.removeUser(userId).subscribe(
      data => { console.log(data); alert("User account deleted")},
      error => { console.log(error); alert("User Account Not Found");}
    );
    }

  detail(userId:number):void{
    this.service.getuserById(userId)
      .subscribe(
        data => { console.log(data); this.user=data},
        error => { console.log(error);  alert(error);}
      );    
}
editnew(userId:number):void{

  this.isDivVisible=true;
  this.service.getuserById(userId)
    .subscribe(
      data => { console.log(data); this.user=data},
      error => { console.log(error);  alert(error);}
    );    
}
 edituser():void{
   this.isDivVisible= false;
  this.service.updateuser(this.user)
  .subscribe(
    data => { console.log(data);  this.user=data ; alert('User Information Updated');this.reloadData()},
    error => { console.log(error);  alert(error);}
  )
}
}
