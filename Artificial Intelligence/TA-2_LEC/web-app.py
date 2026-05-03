import streamlit as st
import tensorflow as tf
from keras.preprocessing import image
from PIL import Image
import numpy as np

st.title("Klasifikasi Jenis Daun Kacang")

uploaded_file = st.file_uploader("Upload Gambar", type=["jpg", "jpeg", "png"])

def load_cnn_model():
    model = tf.keras.models.load_model('./model_here.h5') #Disesukan dengan nama file model
    return model

model = load_cnn_model()

dic = {0: 'Hijau', 1: 'Kedelai', 2: 'Panjang', 3: 'Tanah'} #Disesuaikan dengan kategori klasifikasi yang ditentukan

if uploaded_file is not None:
    x = Image.open(uploaded_file).convert("RGB")
    st.image(x, caption="Gambar Yang Diupload", use_column_width=True)
    x=x.resize((256,256)) #Disesuaikan dengan ukuran gambar yang ditentukan di model
    x = image.img_to_array(x)/255.0
    x = np.expand_dims(x,axis=0)
    p = np.argmax(model.predict(x))
    kelas=dic[p]
    st.write(f"**Prediksi Gambar :** {kelas}")
else:
    st.write("Belum Ada Gambar!!!")