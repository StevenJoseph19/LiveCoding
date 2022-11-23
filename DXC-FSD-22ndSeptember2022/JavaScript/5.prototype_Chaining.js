// function Person() {
//   this.name = "John";
//   this.age = 23;
// }

// adding a prototype
// Person.prototype.age = 24;

// creating object
// const person1 = new Person();
// const person2 = new Person();

// // adding a methode to the constructor function
// Person.prototype.greet = function () {
//   console.log("hello" + " " + this.name);
// };

// person1.greet(); // hello John
// person2.greet(); // hello John

// accessing prototype property
// console.log(person.__proto__); // { age: 24 }

// checking the prototype value before adding property
// console.log(Person.prototype); //{...}

// adding property to constrcutor function
// Person.prototype.gender = "male";

// checking the prototype value after adding property
// console.log(Person.prototype); //{...}

// inheriting the property from prototype
// console.log(person1.gender);
// console.log(person2.gender);

// constructor function
function Person() {
  this.name = "John";
}

// add a property
// Person.prototype.name = "Peter";
Person.prototype.age = 20;

// creating an object
const person1 = new Person();

// accessing prototype property
console.log(person1.__proto__); //age:20

// console.log(person1.name);
// console.log(person1.age);

// changinf the property value of the prototype
// Person.prototype = { age: 50 };

// creating a new object
// const person2 = new Person();

// console.log(person1.age);
// console.log(person2.age);
