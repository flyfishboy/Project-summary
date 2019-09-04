<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7c6321057af5eb793477f23e9c635251ea586a49
function loadConfig(path) {
   var glob = require('glob');
   var object = {};
   var key;

   glob.sync('*', {cwd: path}).forEach(function(option) {
      key = option.replace(/\.js$/,'');
      object[key] = require(path + option);
   });

  return object;
}

module.exports = function(grunt) {
   grunt.loadTasks('grunt-tasks');

   require('time-grunt')(grunt);
   
   // Only load tasks when they are needed
   require('jit-grunt')(grunt, {
      ngtemplates: 'grunt-angular-templates'
   });

   var config = {
      pkg: grunt.file.readJSON('package.json'),
      env: process.env
   };

   grunt.util._.extend(config, loadConfig('./grunt-tasks/options/'));
   grunt.initConfig(config);
<<<<<<< HEAD
=======
=======
>>>>>>> a4ca7d44579152ae23b62615c248ef0f061358be
function loadConfig(path) {
   var glob = require('glob');
   var object = {};
   var key;

   glob.sync('*', {cwd: path}).forEach(function(option) {
      key = option.replace(/\.js$/,'');
      object[key] = require(path + option);
   });

  return object;
}

module.exports = function(grunt) {
   grunt.loadTasks('grunt-tasks');

   require('time-grunt')(grunt);
   
   // Only load tasks when they are needed
   require('jit-grunt')(grunt, {
      ngtemplates: 'grunt-angular-templates'
   });

   var config = {
      pkg: grunt.file.readJSON('package.json'),
      env: process.env
   };

   grunt.util._.extend(config, loadConfig('./grunt-tasks/options/'));
   grunt.initConfig(config);
<<<<<<< HEAD
=======
>>>>>>> 69dc794474d6d55bdb00ce5c53ea480a10f9fb00
>>>>>>> a4ca7d44579152ae23b62615c248ef0f061358be
>>>>>>> 7c6321057af5eb793477f23e9c635251ea586a49
};