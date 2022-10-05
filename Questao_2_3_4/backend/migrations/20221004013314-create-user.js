'use strict';
/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up(queryInterface, Sequelize) {
    await queryInterface.createTable('Users', {
      id: {
        type: Sequelize.DataTypes.UUID,
        defaultValue: Sequelize.DataTypes.UUIDV4,
        primaryKey: true,
      },
      name: {
        type: Sequelize.DataTypes.STRING(50),
        allowNull: false
      },
      lastName: {
        type: Sequelize.DataTypes.STRING(100),
        allowNull: false
      },
      email: {
        type: Sequelize.DataTypes.STRING(100),
        allowNull: false, 
        unique: true
      },
      psw: {
        type: Sequelize.DataTypes.STRING(255),
        allowNull: false
      },
      createdAt: {
        allowNull: false,
        type: Sequelize.DATE
      },
      updatedAt: {
        allowNull: false,
        type: Sequelize.DATE
      }
    });
  },
  async down(queryInterface, Sequelize) {
    await queryInterface.dropTable('Users');
  }
};