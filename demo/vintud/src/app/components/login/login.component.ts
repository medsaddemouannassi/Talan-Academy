import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {UserService} from '../../services/user.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  addLoginForm: FormGroup;
  user: any = {};
  accessToken: string;
  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService
    ) { }

  ngOnInit(): void {
    this.addLoginForm = this.formBuilder.group({
      username: [""],
      password: [""]
    });
  }

  login(): void {
    this.userService.login(this.user).subscribe((data) => {
      // localStorage.setItem('access_token', data.access_token);
      // localStorage.setItem('refresh_token', data.refresh_token);
      // new Headers().set('Authorization', `Bearer ${data.access_token}`);
// if(data.res != "User true"){
      //   this.error = "Pleaser verify your email or password"
      // }else{
      //   if (data.user.role == "admin") {
      //     this.router.navigate(["admin"])
      //   } else {
      //     this.router.navigate([`profile/${data.user.id}`])
      //   }
      // }
    });
  }
}
