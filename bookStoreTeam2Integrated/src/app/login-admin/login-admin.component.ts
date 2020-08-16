import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BookStoreService } from '../book-store.service';
import { BookStoreConstantsService } from '../book-store-constants.service';
import { AppComponent } from '../app.component';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {

  admin:any;
  email:string;
  password:string;
  isSubmitted: boolean = false;
  checkError:boolean=false;
  checkInfo:boolean=false;
  errorMessage:string;
  message:String;
 
  constructor(private service:BookStoreService, private router: Router, private app: AppComponent) {
    
  }

  ngOnInit(){

  }
  onSubmit(form:NgForm)
  { 
    this.checkInfo=false;
    this.checkError=false;
    
    this.service.loginAdmin(this.email,this.password).subscribe(
    (data)=>
    { 
      this.message=data;
      this.checkInfo=true;
      this.checkError=false;
      console.log(data.message);
      alert("LoggedIn Succesfully");
      this.app.loggedIn=true;
      localStorage.setItem("logged","loggedIn");
      this.router.navigate(['displayCategory'])
    },
    
    (error)=>
    {this.errorMessage=error.error.message;
      this.checkError=true;
      this.checkInfo=false;
    });

    form.reset();

  }


}
