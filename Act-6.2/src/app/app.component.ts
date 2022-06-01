import { Component , OnInit } from '@angular/core';
import { FaceSnap } from './models/face-snap.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  mySnap : FaceSnap;
  mySnap1: FaceSnap;
  mySnap2: FaceSnap;
  mySnap3: FaceSnap;
  mySnap4: FaceSnap;

  ngOnInit(): void {
   this.mySnap = new FaceSnap('Archibald',
      'Mon meilleur ami depuis tout petit !',
      'https://i.natgeofe.com/n/56ad4f59-e256-42b1-bf7c-d04193068703/horse_thumb_2x3.jpg',
      new Date(),
      0)
      this.mySnap1 = new FaceSnap('Archibald',
      'Mon meilleur ami depuis tout petit !',
      'https://i.pinimg.com/originals/67/9d/5f/679d5f3107c70d00cce17de8b9983c8b.jpg',
      new Date(),
      0)
      this.mySnap2 = new FaceSnap('Archibald',
      'Mon meilleur ami depuis tout petit !',
      'https://i.pinimg.com/originals/d6/aa/33/d6aa3386e96c412243ec335e0cac979d.jpg',
      new Date(),
      0)
      this.mySnap3 = new FaceSnap('Archibald',
      'Mon meilleur ami depuis tout petit !',
      'https://i.pinimg.com/originals/cc/44/06/cc4406f4460c5b244bc780d7d98db3f7.jpg',
      new Date(),
      0)
      this.mySnap4 = new FaceSnap('Archibald',
      'Mon meilleur ami depuis tout petit !',
      'https://media.istockphoto.com/photos/brown-horse-head-isolated-on-white-picture-id1154581017?k=20&m=1154581017&s=612x612&w=0&h=mXF9NfEXeQEbAZc_YIly8Me_Kmg8-6GsZYypdqzqad8=',
      new Date(),
      0)
    
  }
}
