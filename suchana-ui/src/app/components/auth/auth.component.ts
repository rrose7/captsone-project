import {LoginRequest} from "../../models/LoginRequest";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  user: LoginRequest;
  loginError = false;
  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit() {
    this.user = new LoginRequest();
  }

  submit() {
    console.log(this.user);
    this.authService.login(this.user).subscribe((data) => {
      localStorage.setItem('loggedInUser', JSON.stringify(data));
      if (data.role == 'ROLE_ADMIN') {
        this.router.navigate(['/admin/categories']);
      } else if (data.role == 'ROLE_AUTHOR') {
        this.router.navigate(['/author/articles'])
      }
      this.authService.isLoggedIn();
    }, (error) => {
      this.loginError = true;
    })

  }

  cancel() {
    this.router.navigate(['/']);
  }

}
