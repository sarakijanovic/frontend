import { Component, OnDestroy, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { Smer } from 'src/app/models/smer';
import { SmerService } from 'src/app/services/smer.service';
import { SmerDialogComponent } from '../dialogs/smer-dialog/smer-dialog.component';


@Component({
  selector: 'app-smer',
  templateUrl: './smer.component.html',
  styleUrls: ['./smer.component.css']
})
export class SmerComponent implements OnInit, OnDestroy {

  constructor(private smerService: SmerService,
    private dialog: MatDialog) { }
  subscription: Subscription;
  displayedColumns = ['id', 'naziv', 'oznaka', 'actions'];
  dataSource: MatTableDataSource<Smer>;


  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void {
    //ova metoda se iyvrsava prilikom ucitavanja ove komponentw
    this.loadData();
  }

  public loadData() {
    //ova metoda ce se prva izvrsiti kad bude pkrenua komponenta
    //da bismo mi imali pristup, moramo injektovati servis u okviru ovog ts.a
    //injektujemo zavisnost i to se vrsi na nivou konsturktora 
    //posto smo injektovali, imamo pristup svim metodama u okviru tog servis
    this.subscription = this.smerService.getAllSmerovi().subscribe(
      data => {
        this.dataSource= new MatTableDataSource(data);
      }

      ),

      (error: Error) => {
        console.log(error.name +' '+ error.message)
      }
    

    //rekli smo da je ovo neka metoda gde se mi subscribujemo
    //kako bismo dobili ove komponente iz one observable 

  }

  public openDialog(flag: number, id? : number, naziv? : string, oznaka? : string): void {
    const dialogRef = this.dialog.open(SmerDialogComponent, {data: {id,naziv,oznaka}} );
    //treba da postavimo flag koji nam odg
    //u okviru ove dialog reference cemo vratiti instancu
    //i smestiti vrednost flega unutar toga 

    dialogRef.componentInstance.flag = flag;

    dialogRef.afterClosed().subscribe(res => {
      if(res==1)
      {
        //ukoliko je uspesno, treba da se opet ucitaju podaci 
        this.loadData(); 
      }
    })
  }


}
