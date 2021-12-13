
export class UserProfile {

    constructor(
        private _id: number,
        private _username: string,
        private _ownedGames: string[],
        private _friend: string[]
      )
      {}
    
      public get id(): number {
        return this._id;
      }
      public set id(value: number) {
        this._id = value;
      }
      public get username(): string {
        return this._username;
      }
      public set username(value: string) {
        this._username = value;
      }
      public get ownedGames(): string[] {
        return this._ownedGames;
        }
    public set ownedGames(value: string[]) {
        this._ownedGames = value;
    }
    public get friend(): string[] {
        return this._friend;
    }
    public set friend(value: string[]) {
        this._friend = value;
    }

}