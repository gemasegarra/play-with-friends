export class Matching {
    constructor(
    private _game: string,
    private _user: number,
    private _numberOfPlayers: number,
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
    public get game(): string {
        return this._game;
    }
    public set game(value: string) {
        this._game = value;
    }
    
}