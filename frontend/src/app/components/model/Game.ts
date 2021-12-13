export class Game {
  constructor(
    private _id: number,
    private _name: string,
    private _image: string,
    private _type: Array<String>,
    private _description: string
  ) {}
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

  public get type(): Array<String> {
    return this._type;
  }
  public set type(value: Array<String>) {
    this._type = value;
  }
  public get id(): number {
    return this._id;
  }
  public set id(value: number) {
    this._id = value;
  }
  public get description(): string {
    return this._description;
  }
  public set description(value: string) {
    this._description = value;
  }
}
