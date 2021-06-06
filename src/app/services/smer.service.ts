import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SMER_URL } from '../app.constants';

@Injectable({
  providedIn: 'root'
})
export class SmerService {

  constructor(private httpClient: HttpClient) { }

  public getAllSmerovi() : Observable<any> {
    return this.httpClient.get(`${SMER_URL}`)
    //u smer komponenti ce se ispisati ovi podaci 
    
}
  //ovo je metoda koja iscitava sve smerove, a pozivace onu metodu
  //sa bekenda 
  //obzervabla vraca neki tok podataka, a mi cemo moci da se prijavimo
  //na taj tok podataka 
}
