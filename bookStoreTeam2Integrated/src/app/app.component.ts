import { Component } from '@angular/core';
import { BookStoreConstantsService } from './book-store-constants.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'bookStoreTeam2Integrated';
  loggedIn : boolean ;
 
  constructor(private router: Router){}
  logout(){
    localStorage.setItem("logged","no");
    this.loggedIn=false;
    this.router.navigate(["/login"]);
  }

}
