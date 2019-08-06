import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {LoginRequest} from "../../models/LoginRequest";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {error} from "util";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  user:LoginRequest;
  loginError=false;

  constructor(private router:Router, private authService:AuthService) { }

  ngOnInit() {
  this.user =new LoginRequest();
  }
submit(){
console.log(this.user)
  this.authService.login(this.user).subscribe((data)=> {
    localStorage.setItem('loggeduser', data);
    if (data.role == 'ROLE_ADMIN') {
      this.router.navigate(['/admin/categories']);

    } else if (data.role = 'ROLE_AUTHOR') {
      this.router.navigate(['/author'])
    }
  }, (error) => {
    this.loginError = true;
  })

}
}


