// class Project {
//   constructor() {
//     console.log(new.target);
//   }
// }
// class SoftwareProject extends Project {
//   constructor() {
//     super();
//   }
// }
// var p = new SoftwareProject();

class Project {
  constructor() {
    console.log(new.target);
  }
}
class SoftwareProject extends Project {}
var p = new SoftwareProject();
