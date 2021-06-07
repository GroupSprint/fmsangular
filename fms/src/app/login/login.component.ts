import { Component, OnInit } from '@angular/core';
import {FormControl,FormGroup,FormBuilder, Validators} from "@angular/forms";
import { Router } from '@angular/router';
import { User } from '../User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User=new User();
  addForm!: FormGroup;
  Submitted = false;
  errors : string | undefined;
  constructor(private service:UserService, private router:Router,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    // this.addForm = this.formBuilder.group({
    //   userName: ['', Validators.required, Validators.minLength(2)],
    //   password: ['', Validators.required, Validators.minLength(6)],
    //   AdminName:['', Validators.required, Validators.minLength(2)],
    //   Adminpassword:['', Validators.required, Validators.minLength(6)]
    // });
    this.addForm = this.formBuilder.group({
      userName: [''],
      password: [''],
      AdminName: [''],
      Adminpassword: ['']
    });
  }

  login():void{
    this.Submitted=true;
    if (this.addForm.invalid) {
      return;  }
      else{
     console.log(this.addForm.value);
        this.user = this.addForm.value;
        this.user.userType='Customer';
        // alert("username: "+this.user.userName+" password :"+this.user.password+"Type: "+this.user.userType)
     this.service.validate(this.user.userName,this.user.password,this.user.userType)
      .subscribe(
        data => { console.log(data); alert('Successful Login');
      this.user=data;
      sessionStorage.setItem('userId',this.user.userId+'');
      sessionStorage.setItem('userName',this.user.userName);
      sessionStorage.setItem('userType',this.user.userType+'');
      this.router.navigate(['/userhome'])
      },
      error => { console.log(error);
        this.errors=error.error.message;
        
        // alert("Wrong Login Credentials")
      }
      );
    }
  }

  Adminlogin():void{
    this.Submitted=true;
    if (this.addForm.invalid) {
      return;  }
      else{
     console.log(this.addForm.value);
        this.user.userName = this.addForm.value.AdminName;
        this.user.password= this.addForm.value.Adminpassword;
        this.user.userType='Admin';
        // alert("username: "+this.user.userName+" password"+this.user.password+" "+this.user.userType)
     this.service.validate(this.user.userName,this.user.password,this.user.userType)
      .subscribe(
        data => { console.log(data); alert('Admin Successful Login');
      this.user=data;
      sessionStorage.setItem('userId',this.user.userId+'');
      sessionStorage.setItem('userName',this.user.userName);
      sessionStorage.setItem('userType',this.user.userType+'');
      this.router.navigate(['/adminhome'])
      },
        error => { console.log(error);
          this.errors=error.error.message;
          
           alert("Wrong Login Credentials")
        }
      );
    }
}
}
