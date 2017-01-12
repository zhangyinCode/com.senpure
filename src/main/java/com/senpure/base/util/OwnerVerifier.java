package com.senpure.base.util;


import java.io.Serializable;

public interface OwnerVerifier {

    boolean verify(Serializable ownerId, Serializable resourceId);
}
