import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class DataserviceService {

  constructor(private http:HttpClient) { }

  clicks() {   return  "Now:" + new Date();  }

  getUsers(): Observable<any> {
    return this.http.get('https://reqres.in/api/users');
  }
}
