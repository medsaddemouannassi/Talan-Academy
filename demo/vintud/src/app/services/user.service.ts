import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {tap} from 'rxjs/operators';
import {JwtHelperService} from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  accessJWT: string;
  refreshJWT: string;
  username: string;
  roles: any;

  constructor(private http: HttpClient) { }

  login(user: any): any {
    return this.http.post<any>('http://localhost:8080/login', user).pipe(tap(res => {
      localStorage.setItem('access_token', res.access_token);
      localStorage.setItem('refresh_token', res.refresh_token);
      this.parseAccessJWT();
    }));
  }

  parseAccessJWT(): any {
    const jwtHelper = new JwtHelperService();
    const objJwt = jwtHelper.decodeToken(localStorage.getItem('access_token'));
    this.username = objJwt.sub;
    this.roles = objJwt.roles;
  }

  getAllUsers(): any {
    const headers = new HttpHeaders({Authorization: `Bearer ${localStorage.getItem('access_token')}`});
    return this.http.get<any>('http://localhost:8080/user', {headers});
  }
}
