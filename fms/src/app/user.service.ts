import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { User } from './User';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl='http://localhost:8082/fms/user';
  constructor(private http:HttpClient) { }

getUsers(): Observable<any> {
    return this.http.get(`${this.baseUrl}/viewAllUsers`).pipe(catchError(this.handleError));
}
createUser(user: object): Observable<Object>{
  return this.http.post(`${this.baseUrl}/addUser`, user).pipe(catchError(this.handleError));
}
removeUser(id:number): Observable<any> {
  return this.http.delete(`${this.baseUrl}/removeUser/`+id).pipe(catchError(this.handleError));
}
updateuser(user: User): Observable<any> {
  return this.http.put(`${this.baseUrl}/updateUser`, user).pipe(catchError(this.handleError));
}
getuserById(id: number): Observable<any> {
  return this.http.get(`${this.baseUrl}/getUserById/${id}`).pipe(catchError(this.handleError));
}
validate(userName:String,password:String,userType:String): Observable<any>{
  return this.http.get(`${this.baseUrl}/validateUser/${userName}/${password}/${userType}`).pipe(catchError(this.handleError));
}
isLoggedAdmin(){
  let name = sessionStorage.getItem('userType');
  if(name=='Admin')
      return true;
      else
      return false;
}
isLoggedUser(){
  let name = sessionStorage.getItem('userType');
  if(name=='Customer')
      return true;
      else
      return false;
}

private handleError(error: HttpErrorResponse){
  if(error.error instanceof ErrorEvent){
      console.error('Client Side Error: ' , error.error.message);
      alert('client side error');
  }else{
    console.error('Server Side Error: ', error);
    alert('Server side error');
  }
  return throwError('There is problem with Service');
}
}
 
