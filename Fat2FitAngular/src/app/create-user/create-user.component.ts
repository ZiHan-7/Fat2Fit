import { Component, OnInit, Input } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from '../user.service';


export interface Data{
  inputName: string;
  inputAge : number;
  inputWeight : number;
  inputHeight : number;
}
@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss']
})
export class CreateUserComponent implements OnInit {

  userForm =new FormGroup({
    inputName : new FormControl(),
    inputAge : new FormControl(),
    inputWeight : new FormControl(),
    inputHeight : new FormControl()
  })
  
  // @Input()
  // inputName = new FormControl('');
  // @Input()
  // inputAge = new FormControl('');
  // @Input()
  // inputWeight = new FormControl('');
  // @Input()
  // inputHeight = new FormControl('');

  constructor(private userService: UserService) { }

  ngOnInit() {
  }
 onSubmit(){
  this.userService.setFormValues(this.userForm.value, "user")
  console.log(this.userForm.value)
 }

  onClickReset() {
  
  this.userForm.value.reset();

  }

}
