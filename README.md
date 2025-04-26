# Chemical Inventory Management System

This project is a **Chemical Inventory Management System** designed to help manage and track chemicals in a laboratory or industrial setting. The system allows users to input, update, search, and track chemical data along with relevant safety information (SDS) for each chemical.

## Features

- **Dashboard:** A user-friendly interface to manage chemical inventory.
- **Search Chemicals:** Search for chemicals by various filters such as name, CAS number, barcode, etc.
- **Add a Container:** Allows users to input new chemicals into the system with details like name, quantity, location, etc.
- **Safety Data Sheets (SDS):** Retrieve SDS for each chemical to ensure safe handling and usage.
- **User Authentication:** Ensure only authorized personnel can modify the inventory.
- **Locations:** Manage the storage locations of chemicals for easier tracking.
- **Order Requests:** Submit and manage orders for chemicals.
- **Administration:** Access the admin panel to manage user roles and system configurations.

```
## Project Structure

```plaintext
├── .idea/                          # IntelliJ IDEA project configuration files
├── 0_mockup UI/                    # UI mockups for the system
├── Chemical_inventory_system_files/ # Files related to chemical data storage and management
├── lib/                            # External libraries used by the project (e.g., database, security)
├── resources/                      # Resources like FXML files for the UI, images, and styles
├── src/                            # Source code for the application, including controllers and models
├── .gitignore                      # Git ignore file to exclude unnecessary files from version control
├── Chemical_Inventory_Requirements_v1.docx  # Project requirement document
└── CS225_Final_FrontEnd.xlsx       # Project self management tool

