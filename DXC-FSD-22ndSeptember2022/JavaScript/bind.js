// const person = {
//   firstName: "John",
//   lastName: "Doe",
//   fullName: function () {
//     return this.firstName + " " + this.lastName;
//   },
// };
// const member = {
//   firstName: "Hege",
//   lastName: "Nilsen",
// };
// let fullName = person.fullName.bind(member);

// console.log(fullName());

// const person = {
//   firstName: "John",
//   lastName: "Doe",
//   display: function () {
//     console.log(this.firstName + " " + this.lastName);
//   },
// };

// person.display();

// const person = {
//   firstName: "John",
//   lastName: "Doe",
//   display: function () {
//     console.log(this.firstName + " " + this.lastName);
//   },
// };

// setTimeout(person.display, 3000);

const person = {
  firstName: "John",
  lastName: "Doe",
  display: function () {
    console.log(this.firstName + " " + this.lastName);
  },
};

let display = person.display.bind(person);

setTimeout(display, 3000);
