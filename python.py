import tkinter as tk
from tkinter import ttk
from PIL import Image, ImageTk

# Create the main application window
tk_root = tk.Tk()
tk_root.title('Liegeplatzdaten')
tk_root.geometry('650x400')
tk_root.configure(bg='lightgrey')

# Set the app icon
tk_root.iconphoto(False, tk.PhotoImage(file='logo.png'))  # Update with correct path

# Create the main content area
content_frame = tk.Frame(tk_root, bg='lightgrey')
content_frame.pack(expand=True, fill='both', padx=10, pady=10)

# Create left panel for form inputs
left_panel = tk.Frame(content_frame, bg='lightgrey')
left_panel.pack(side='left', fill='y', padx=5, pady=5)

# Add form inputs
inputs = {
    'Bezeichnung:': 'A34-1',
    'Länge (m):': '',
    'Breite (m):': '',
    'Wassertiefe (cm):': '',
    'Status:': 'verfügbar'
}

for idx, (label_text, value) in enumerate(inputs.items()):
    label = tk.Label(left_panel, text=label_text, bg='lightgrey')
    label.pack(anchor='w', pady=2)
    if not idx:  # If first item (Bezeichnung)
        entry = tk.Entry(left_panel, bg='lightgrey', fg='orange')
        entry.insert(0, value)
        entry.config(state='readonly')
    elif label_text == 'Status:':
        entry = ttk.Combobox(left_panel, values=[value])
        entry.current(0)
    else:
        entry = tk.Entry(left_panel)
    entry.pack(fill='x', pady=2)

# Create right panel for image
right_panel = tk.Frame(content_frame, bg='lightgrey')
right_panel.pack(side='left', fill='both', expand=True, padx=5, pady=5)

# Add image
image_label = tk.Label(right_panel, text='Bild:', bg='lightgrey')
image_label.pack(anchor='n')
image = Image.open('grafik.jpg').resize((200, 150))  # Update with correct path
image_img = ImageTk.PhotoImage(image)
image_display = tk.Label(right_panel, image=image_img, bg='lightgrey')
image_display.pack(expand=True)

# Create footer for buttons
footer_frame = tk.Frame(tk_root, bg='lightgrey')
footer_frame.pack(fill='x', pady=10)

buttons = ['Daten speichern', 'Neues Bild', 'Dialog schließen']
for button_text in buttons:
    button = tk.Button(footer_frame, text=button_text, bg='grey', fg='black', width=15)
    button.pack(side='left', padx=10)

# Function to handle button clicks
def on_button_click(button):
    print(f'{button} clicked')

# Attach command to buttons
_save_btn, _new_btn, _close_btn = footer_frame.winfo_children()
_save_btn.config(command=lambda: on_button_click('Daten speichern'))
_new_btn.config(command=lambda: on_button_click('Neues Bild'))
_close_btn.config(command=tk_root.quit)

# Main loop
tk_root.mainloop()
