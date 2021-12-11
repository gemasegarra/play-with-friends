export class Matching {
    constructor(
    private _game: number,
    private _user: number,
    private _numberOfPlayers: number,
    private _comment: string
    ){
    }
    public get numberOfPlayers(): number {
        return this._numberOfPlayers;
    }
    public set numberOfPlayers(value: number) {
        this._numberOfPlayers = value;
    }
    public get user(): number {
        return this._user;
    }
    public set user(value: number) {
        this._user = value;
    }
    public get game(): number {
        return this._game;
    }
    public set game(value: number) {
        this._game = value;
    }
    public get comment(): string {
        return this._comment;
    }
    public set comment(value: string) {
        this._comment = value;
    }
}