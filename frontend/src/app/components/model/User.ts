export class User {
 
    constructor(
      private _name: string,
      private _password: string
    )
    {}
  
    public get name(): string {
      return this._name;
    }
    public set name(value: string) {
      this._name = value;
    }

    public get password(): string {
        return this._password;
    }
    public set password(value: string) {
        this._password = value;
    }
    
     
    }