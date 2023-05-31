export class UserProfile {
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
        password: string
    ) {
        this.username = username
        this.name = name
        this.apellidos = apellidos
        this.telephoneNumber = telephoneNumber
        this.email = email
        this.password = password
    }

    
}