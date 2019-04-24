import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Observable, throwError} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userName: string;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    let url = "http://localhost:5000/user";
    let headers: HttpHeaders = new HttpHeaders({
      "Authorization": "Basic " + sessionStorage.getItem('token')
    });
    let options = {headers: headers}
    this.http.post<Observable<Object>>(url, {}, options)
      .subscribe(res => {
          this.userName = res['name']
        },
        error => {
          if (error.status == 401)
            alert('Access Denied - unauthorized');
        }
      );
  }

  logout(){
    sessionStorage.setItem('token', '');
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  };

}
