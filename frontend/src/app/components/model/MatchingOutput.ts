export class MatchingOutput {
  
  
    constructor(
    private _id: number,
    private _game: string,
    private _user: string,
    private _numberOfPlayers: number,
    private _comment: string,
    private _matches: string[]
    ){
    }
    public get numberOfPlayers(): number {
        return this._numberOfPlayers;
    }
    public set numberOfPlayers(value: number) {
        this._numberOfPlayers = value;
    }
    public get user(): string {
        return this._user;
    }
    public set user(value: string) {
    }
    public get game(): string {
        return this._game;
    }
    public set game(value: string) {
        this._game = value;
    }
    public get comment(): string {
        return this._comment;
    }
    public set comment(value: string) {
        this._comment = value;
    }
    public get matches(): string[] {
        return this._matches;
    }
    public set matches(value: string[]) {
        this._matches = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
}