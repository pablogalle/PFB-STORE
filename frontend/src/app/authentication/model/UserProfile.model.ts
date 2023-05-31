export class UserProfile {
    username: string;
    name: string;
    apellidos: string;
    phoneNumber: string;
    email: string;
    password: string;

    constructor(
        username: string,
        name: string,
        apellidos: string,
        phoneNumber: string,
        email: string,
        password: string
    ) {
        this.username = username
        this.name = name
        this.apellidos = apellidos
        this.phoneNumber = phoneNumber
        this.email = email
        this.password = password
    }

    public getUsername(): string {
        return this.username;
    }

    public setUsername(username: string): void {
        this.username = username;
    }

    public getName(): string {
        return this.name;
    }

    public setName(name: string): void {
        this.name = name;
    }

    public getSurname(): string {
        return this.apellidos;
    }

    public setSurname(surname: string): void {
        this.apellidos = surname;
    }

    public getPhoneNumber(): string {
        return this.phoneNumber;
    }

    public setPhoneNumber(phoneNumber: string): void {
        this.phoneNumber = phoneNumber;
    }

    public getEmail(): string {
        return this.email;
    }

    public setEmail(email: string): void {
        this.email = email;
    }

    public getPassword(): string {
        return this.password;
    }

    public setPassword(password: string): void {
        this.password = password;
    }
}