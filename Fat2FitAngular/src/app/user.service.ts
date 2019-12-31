import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

interface UserFormValues {
  inputName : string
  inputAge :  string
  inputWeight :  string
  inputHeight :  string
}
interface FormValues {
  user?: UserFormValues
}

@Injectable({
  providedIn: 'root'
})

export class UserService {
  formValues = new BehaviorSubject<FormValues>({})
  constructor(private http: HttpClient) {}

  setFormValues(specificFormValues, formName){
    let currentFormValues = this.formValues.getValue()
    currentFormValues[formName] = specificFormValues

    this.formValues.next(currentFormValues)
  }

  saveToDb(){
    let currentValue = this.formValues.getValue()

    this.http.post("http://localhost:8080/users", {
      "name": currentValue.user.inputName,
      "age": currentValue.user.inputAge,
      "original_weight": currentValue.user.inputWeight,
      "height ": currentValue.user.inputHeight,

    })

  }

}