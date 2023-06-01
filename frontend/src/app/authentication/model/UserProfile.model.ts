export class UserProfile{

    id?: number
    username: string;
    name: string;
    apellidos: string;
    telephoneNumber: string;
    email: string;
    password: string;

    constructor(
        username: string,
        name: string,
        apellidos: string,
        telephoneNumber: string,
        email: string,
        password: string,
        id?: number,
    ) {
        this.id = id
        this.username = username
        this.name = name
        this.apellidos = apellidos
        this.telephoneNumber = telephoneNumber
        this.email = email
        this.password = password
    }

    
}