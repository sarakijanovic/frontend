
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Smer } from 'src/app/models/smer';
import { SmerService } from 'src/app/services/smer.service';
import { Component, OnInit, Inject} from '@angular/core'; 

@Component({
  selector: 'app-smer-dialog',
  templateUrl: './smer-dialog.component.html',
  styles: [
  ]
})
export class SmerDialogComponent implements OnInit {

  public flag: number;
  //od zavisnosti ce nam trebati jedan snack bar -angular komponenta 
//koja ce obavestenje poslati korisniku nakon neke aktivnosti 
//u konsturktoru da bismo to omogucili injektujemo sl:
  constructor(public snackBar: MatSnackBar,
    //treba nam i referenca na nas dijalog: 
    public dialogRef: MatDialogRef<SmerDialogComponent>,
    @Inject (MAT_DIALOG_DATA) public data: Smer,
    public smerService: SmerService ) {
    //imacemo taj dijalog, injektovacemo podatke, i servis sa kog 
    //uyimamo podatke 
      /*otvori mi dijalog kad kliknem na dugme, i prosledice se 
      neki fleg. mi cemo yahvaljujuci htmlu koji ce se naci u 
      dijalgou, pokupiti taj fleg */ 

      //u data se ucitavaju sve vrednosti iz dijaloga
     }


  ngOnInit(): void {

  }

  public addSmer (): void {

    //mi cemo ovo iyvrsiti pomocu servisne metode jer se komunikacija
    /*vrsi pomocu  servisnih klasa - smerService. mi trenutno u toj klasi
    imamo samo getAllSmerovi, pa tamo rpavimo novu petodu */
      //pozivanje servisne metode
      this.smerService.addSmer(this.data).subscribe(() => {
        this.snackBar.open('Upesno dodat smer: '+ this.data.naziv, 'OK', 
         {duration : 2500})
        }),
        (error: Error) => {
          console.log(error.name + ' ' + error.message);
          this.snackBar.open('Doslo je do greske prilikom dodavanja novog smera', 'Zatvori', 
         {duration : 2500
        })

        }

  }

  public updateSmer(): void {

    this.smerService.updateSmer(this.data).subscribe(() => {
      this.snackBar.open('Upesno modifikovan smer: '+ this.data.naziv, 'OK', 
       {duration : 2500})
      }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open('Doslo je do greske prilikom modifikovanja smera', 'Zatvori', 
       {duration : 2500
        })

      } 

    }

    public deleteSmer() : void {

      this.smerService.deleteSmer(this.data.id).subscribe(() => {
        this.snackBar.open('Upesno obrisan smer: '+ this.data.naziv, 'OK', 
         {duration : 2500})
        }),
        (error: Error) => {
          console.log(error.name + ' ' + error.message);
          this.snackBar.open('Doslo je do greske prilikom brisanja smera', 'Zatvori', 
         {duration : 2500
          })
  
        } 
    }

    public cancel(): void {
      //mogucnost da odustane od brisanja 
      //referenciramo dijalog koji smo kreirali i poyovemo metodu close
      this.dialogRef.close(); 
      this.snackBar.open('Odustali ste.', 'Zatvori', {
        duration: 1000}) 
    }


}


