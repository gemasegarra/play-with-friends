export class Game {

    constructor(
        private _name: string,
        private _image: string,
        private _rating: string,
        private _type: Array<String>
    )
    {}
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }

    public get image(): string {
        return this._image;
    }
    public set image(value: string) {
        this._image = value;
    }
    
    public get rating(): string {
        return this._rating;
    }
    public set rating(value: string) {
        this._rating = value;
    }
 
    public get type(): Array<String> {
        return this._type;
    }
    public set type(value: Array<String>) {
        this._type = value;
    }
  


}